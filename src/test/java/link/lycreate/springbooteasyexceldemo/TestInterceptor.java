package link.lycreate.springbooteasyexceldemo;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author charlesYan
 * @Description //链式调用
 * @Date 16:36 2020/9/29
 * @Param
 * @return
 **/
interface Executor {
	void execute(String sql);
}

class DefaultExecutor implements Executor {

	@Override
	public void execute(String sql) {
		System.out.println("execute " + sql);
	}
}

interface Interceptor {

	Object interceptor(Invocation invocation) throws Exception;
	
	Object plugin(Object target);

}

class LogInterceptor implements Interceptor {

	@Override
	public Object interceptor(Invocation invocation) throws Exception {
		System.out.println("execute start time " + System.nanoTime());
		Object result = invocation.process();
		System.out.println("execute end time " + System.nanoTime());
		return result;
	}

	@Override
	public Object plugin(Object target) {
		return ExecutorProxyFactory.newProxy(target, this);
	}

}
class TransactionInterceptor implements Interceptor{

	@Override
	public Object interceptor(Invocation invocation) throws Exception {
		System.out.println("Transaction begin ...");
		Object result = invocation.process();
		System.out.println("Transaction commit ...");
		return result;
	}

	@Override
	public Object plugin(Object target) {
		return ExecutorProxyFactory.newProxy(target, this);
	}
	
}

class InterceptorChain{
	private List<Interceptor> intereptors = new ArrayList<>();
	
	public void addInterceptor(Interceptor interceptor){
		this.intereptors.add(interceptor);
	}
	
	public Object pluginAll(Object target) {
		for (Interceptor interceptor : intereptors) {
			target = interceptor.plugin(target);
		}
		return target;
	}
	
}


class Invocation {
	private Object target;
	private Method method;
	private Object[] args;

	public Invocation(Object target, Method method, Object[] args) {
		this.target = target;
		this.method = method;
		this.args = args;
	}

	public Object process() throws Exception {
		return method.invoke(target, args);
	}

}

class TargetProxyHandler implements InvocationHandler {
	private Object target;
	private Interceptor interceptor;

	public TargetProxyHandler(Object target, Interceptor interceptor) {
		this.target = target;
		this.interceptor = interceptor;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Invocation invocation = new Invocation(target,method,args); 
		Object result = interceptor.interceptor(invocation);
		return result;
	}
}

class ExecutorProxyFactory {
	public static Object newProxy(Object target,Interceptor interceptor) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new TargetProxyHandler(target,interceptor));
	}

}

public class TestInterceptor {
	public static void main(String[] args) {
		Executor exe = new DefaultExecutor();
		Interceptor LogInterceptor = new LogInterceptor();
		Interceptor txInterceptor = new TransactionInterceptor();
		InterceptorChain interceptorChain = new InterceptorChain();
		interceptorChain.addInterceptor(LogInterceptor);
		interceptorChain.addInterceptor(txInterceptor);
		Executor newProxy = (Executor)interceptorChain.pluginAll(exe);
//		Executor newProxy = (Executor) ExecutorProxyFactory.newProxy(exe,LogInterceptor);
		newProxy.execute("select");
	}
}
