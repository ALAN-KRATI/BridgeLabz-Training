import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotNull{
    String message() default " Name can't be null";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime{
    String message() default "Time taken: ";
}

class User{
    @NotNull
    private String name;

    public User(){}

    public User(String name){
        this.name = name;
    }

    @LogExecutionTime
    public void counter(int num){
        int count = 0;
        for(int i = 0; i < num; i++){
            count *= i;
        }

        System.out.println(count);
    }

    public void display(){
        System.out.println("Name: " + name);
    }
}

class Validator{
    public static void Validate(Object obj) throws Exception{
        Class<?> cls = obj.getClass();

        for(Field field : cls.getDeclaredFields()){
            field.setAccessible(true);

            if(field.isAnnotationPresent(NotNull.class)){
                Object name = field.get(obj);
                if(name == null){
                    NotNull annotation = field.getAnnotation(NotNull.class);
                    throw new Exception(annotation.message());
                }
            }
        }

        for(Method method: cls.getDeclaredMethods()){
            if(method.isAnnotationPresent(LogExecutionTime.class)){
                LogExecutionTime annotation = method.getAnnotation(LogExecutionTime.class);
                long start = System.currentTimeMillis();
                method.invoke(obj, 100);
                long end = System.currentTimeMillis();

                System.out.println(annotation.message() + (end - start) + "ms");
            }
        }

        Constructor<?> constructor = cls.getConstructor(String.class);
        User user = (User) constructor.newInstance("Emma");
        user.display();

    }
}

public class Annotation{
    public static void main(String[] args){

        User user = new User();

        try{
            Validator.Validate(user);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}