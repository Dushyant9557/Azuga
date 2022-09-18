import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class touch{

public static void main(String []path) throws Exception{
File f = new File(path[0]);
if (f.exists()) {
        System.out.println("cannot create");
}
else if(f.createNewFile()){
System.out.println("file created successfully");

}
else{
System.out.print("cannot created file");
}
}
}