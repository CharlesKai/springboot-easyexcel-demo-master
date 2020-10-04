package link.lycreate.springbooteasyexceldemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface SearchDao{
	Object selectList();
	
	Object update();
}
class MyProxyHandler implements InvocationHandler{
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("MyProxyHandler.invoke()");
		String name = proxy.getClass().getName();
		String methodName = method.getName();
		System.out.println(name+" . "+ methodName);
		return null;
	}
}
class MapperProxyFactory<T>{
	private Class<T> target;
	public MapperProxyFactory(Class<T> target) {
		this.target = target;
	}
	
	public Object newInstance(MyProxyHandler handler){
		return Proxy.newProxyInstance(target.getClassLoader(), 
				new Class[]{target}, handler);
	}
}


public class TestProxy {
	
	public static void main(String[] args) throws Exception {
		Class<SearchDao> target = SearchDao.class;
		MyProxyHandler handler = new MyProxyHandler();
		MapperProxyFactory f = new MapperProxyFactory(SearchDao.class);
		SearchDao newInstance = (SearchDao)f.newInstance(handler);
//		SearchDao newInstance = (SearchDao)Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, handler);
		newInstance.selectList();
		newInstance.update();
		InvocationHandler invocationHandler = Proxy.getInvocationHandler(newInstance);
		System.out.println(invocationHandler.getClass().getName());
		
		
//		MyProxyHandler myProxyHandler = new MyProxyHandler();
//		MapperProxyFactory mapperProxyFactory = new MapperProxyFactory(SearchDao.class);
//		SearchDao newInstance =(SearchDao) mapperProxyFactory.newInstance(myProxyHandler);
//		System.out.println(newInstance.getClass().getName());
//		newInstance.selectList();
//

		// 存在疑问：
		// 1. debug为什么每次都会打印：link.lycreate.springbooteasyexceldemo.$Proxy0 . toString
	}
	
}
