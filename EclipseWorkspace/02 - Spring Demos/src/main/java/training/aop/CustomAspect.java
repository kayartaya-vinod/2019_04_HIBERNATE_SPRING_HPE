package training.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import training.dao.DaoException;

@Component
@Aspect
public class CustomAspect {

	@Pointcut("execution( * training.dao.ProductDao.count(..))")
	public void pc1() {
	}

	@Pointcut("execution( * training.dao.ProductDao.getProductsBySupplier(..))")
	public void pc2() {
	}

	// execution (
	// [return-type-pattern]
	// [package-pattern].
	// [declaring-type-pattern].
	// [method-pattern](
	// [argument-pattern]))
	// @Before("execution( * training..ProductDao.*(..))")
	// @Before("execution( int training..ProductDao.*(..))")
	// @Before("execution( java.util.List training..*Dao.*(..))")
	// @Before("execution( * training..ProductDao.*(Double, Double))")
	// @Before("execution( * training.dao.ProductDao.count())")
	// @Before("pc1() || pc2()")
	public void methodLogger(JoinPoint jp) {
		System.out.println("----------------------------------------");
		System.out.println("The function " + jp.getSignature().getName() + " called!");
		System.out.println("Arguments supplied are: " + Arrays.toString(jp.getArgs()));
		System.out.println("The target object is an instanceof " + jp.getTarget().getClass());
		System.out.println("Kind of JoinPoint is " + jp.getKind());
		System.out.println("----------------------------------------");
	}

	@Around("execution( * training.dao.ProductDao.*(Double, Double))")
	public Object swapArgs(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		Double a = new Double(args[0].toString());
		Double b = new Double(args[1].toString());
		if (a > b) {
			args = new Object[] { b, a };
		}
		return pjp.proceed(args);
	}
	
	@AfterThrowing(pointcut = "execution(* training..*Dao.*(..))", throwing = "ex")
	public void convertToDaoException(Exception ex) throws DaoException {
		if (ex instanceof DaoException == false) {
			throw new DaoException(ex);
		}
	}

}










