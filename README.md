
# Java Training
## Week 1
In the first week, I mimic Linux command like mv, echo, cp, rm, 
mkdir, rmdir, date, cat, pwd, whoami, touch

mimic the behaviour of ls command

mimic the wc command


## Week 2
Implementing the pipe command

## Week 3
Call weather REST API programmatically and generate a CSV file

## Week 4
Crafting clean & quality code in Java 

Wrapping up learning Java 

Zip and unzip the generated reports / files using Java; Send an email with the reports automatically from Java code 

## Week 5
Unit testing with Junit 
## Demo

### Demo of mv

import java.util.*;

import java.io.*;

import java.nio.file.Files;

import java.nio.file.*;
 
public class MV
{

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter source  address");
        String source = sc.nextLine();
        System.out.println("Enter destination address");
        String destination = sc.nextLine();
        Path temp = Files.move(Paths.get(source),Paths.get(destination));
 
        if(temp != null)
        {
            System.out.println("File moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
    }
}



### Demo of echo command

import java.util.*;

public class Echo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String echo = sc.nextLine();
        System.out.print(echo);
        sc.close();
    }   
}

### Demo of pwd

public class pwd {

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
    }
}

### Demo of the pipe command

import java.io.*;

import java.nio.file.*;

import java.util.*;

/**
 * This class mimics the pipe command of linux
 */

public class PipeC {


    public static String cat(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String sort(String str) {
        String[] lines = str.split("\n\r|\r|\n");
        List<String> ls = new ArrayList<>();
        Collections.addAll(ls, lines);
        Collections.sort(ls);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ls.size(); i++){
            if(i < ls.size()-1){
                sb.append(ls.get(i)).append("\n");
            }
            else{
                sb.append(ls.get(i));
            }

        }
        return sb.toString();
    }

    public static String head(String str,int len) {
        String[] lines = str.split("\n\r|\r|\n");
        ArrayList<String> ar = new ArrayList<>(Arrays.asList(lines));
        String ans = "";
        int j=0;
        for(int i=0; i<ar.size(); i++) {
            if (j>=len){
                break;
            }
            if(i < ar.size()-1){
                ans = ans + (ar.get(i)+"\n");
                j++;
            }
            else{
                ans = ans + ar.get(i);
            }
        }
        return ans;
    }

    public static String grep(String str, String mark) {
        String[] lines = str.split("\n\r|\r|\n");
        ArrayList<String> ar = new ArrayList<>(Arrays.asList(lines));
        String ans = "";
        for(String s:ar) {
            if (s.contains(mark)) {
                ans = ans + (s);
            }
        }
        return ans;
    }

    public static String tail(String str,int len) {
        String[] lines = str.split("\n\r|\r|\n");
        ArrayList<String> ar = new ArrayList<>(Arrays.asList(lines));
        StringBuilder ans = new StringBuilder();
        int k=ar.size()-len;
        while(k< ar.size()) {
            if(k==ar.size()-1) {
                ans.append(ar.get(k));
                k++;
            }
            else{
                ans.append(ar.get(k)).append("\n");
                k++;
            }
        }
        return ans.toString();
    }

    public static String ptest(String str) {

        String[] s = str.split(" ");
        if (s[0].equals("cat") && s.length <= 3) {
            System.out.println(cat(s[1]));
        }
        else if (s.length >= 3) {
            if (s[0].equals("cat") && s[2].equals("|") && s[3].equals("sort")) {
                return sort(cat(s[1]));
            }
            if (s[0].equals("cat") && s[2].equals("|") && s[3].equals("head")) {
                return head(cat(s[1]) ,Integer.parseInt(s[4]));
            }
            if (s[0].equals("cat") && s[2].equals("|") && s[3].equals("tail")) {
                return tail(cat(s[1]) ,Integer.parseInt(s[4]));
            }
            if (s[0].equals("cat") && s[2].equals("|") && s[3].equals("grep")) {
                return grep(cat(s[1]) , s[4]);
            }
        }
        return "";
    }

}

## Deployment

To deploy this project run

```bash
  npm run deploy
```


## FAQ

#### How to mimic pipe command

For a solution go to the demo

#### how to call rest API.

I call weather API. By using this API we check the weather of any state, province or country.


## Features

- Light/dark mode toggle
- Live previews
- Fullscreen mode
- Cross platform


## Feedback

If you have any feedback, please reach out to us at dushyants@azuga.com

