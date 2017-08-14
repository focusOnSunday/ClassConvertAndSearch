import java.util.Scanner;
import org.junit.Test;

public class classSearch {

    @Test
    public void classCreate(){
        System.out.println("Please input the files you want to convert:");
        Scanner in=new Scanner(System.in);
        String classesPath=in.nextLine();
        System.out.println("Please input the file you want to put:");
        String javaPath=in.nextLine();
        try{

            if(null==javaPath&&"".equals(javaPath)){
                convertClassToJava(classesPath);
            }else{
                convertClassToJava(classesPath,javaPath);
            }
        }catch(Exception e){
            System.out.println("Your input Path maybe wrong. Please check it again");
        }
    }

    private String convertClassToJava(String classesPath,String javaPath) throws Exception{
//        String javaPath="";
        final Runtime runtime = Runtime.getRuntime();
        Process process = null;
        StringBuffer commandStr = new StringBuffer("jad -o -r -sjava -d");
        commandStr.append(javaPath);
        commandStr.append(" ");
        commandStr.append(classesPath);
        commandStr.append("//**//*");
        String commandStrResult = commandStr.toString();
        System.out.println(commandStrResult);
        System.out.println("Loading.Please Wait.............");
        process = runtime.exec(commandStr.toString());
        return javaPath;
    }

    private String convertClassToJava(String classesPath) throws Exception{
        String javaPath = classesPath+"\\src";
        javaPath = convertClassToJava(classesPath,javaPath);
        return javaPath;
    }


}