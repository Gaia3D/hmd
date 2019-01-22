//package hmd.config;
//
//import org.springframework.util.Assert;
//
//public class ContextHolder {
//
//	private static final ThreadLocal<Database> CONTEXT = new ThreadLocal<>();
//
//    public static void set(Database database) {
//    	Assert.notNull(database, "database cannot be null");
//        CONTEXT.set(database);
//    }
//
//    public static Database get() {
//        return CONTEXT.get();
//    }
//
//    public static void clear() {
//        CONTEXT.remove();
//    }
//}
