/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lena_handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luybe
 */
public class LENA_HANDLER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = "file.ppm"; // replace with your file name
        try {
            BufferedReader reader=null;
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("lena.ppm"), "Cp1252"));
            System.out.println("READEr + " + reader.readLine());
            
            //
            
            InputStream in = new FileInputStream(new File("lena.ppm"));
            // Read the header
            String header = readLine(in);
            String[] p=  readLine(in).split(" ");
            String width =  p[0];
            String height = p[1];
            int maxColor = Integer.parseInt(readLine(in));
             System.out.println("Header: " + header);
            System.out.println("Width: " + width);
            System.out.println("Height: " + height);
            System.out.println("Max Color: " + maxColor);
            // Read the data
            String[][] data = new String[ 512*3][512*3];
           Writer wr = new FileWriter("copie.ppm");
           wr.write(header+"\n");
           wr.write( String.valueOf(width +" "));
           wr.write(String.valueOf(height+"\n"));
           wr.write(String.valueOf(maxColor+"\n"));
               
            for (int i = 0; i < 512; i++) {
     
                for(int j=0;i<512;j++)
                {
                      //data[i][j] = Integer.toString(in.read()) ;
                       //System.out.println(Integer.toString(in.read())); 
                      if(j==512)
                          break;
        
                }
              
            }
          writeToFile(data,512,512,wr);
   
            in.close();
            
                      wr.close();
            // Print the header and data
           
            
           
            
                       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String readLine(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = in.read()) != '\n') {
            sb.append((char) c);
        }
        return sb.toString();
    }
      public static void writeToFile(String[][] data, int height, int width  ,Writer wr ) throws IOException {
             
       
            String[][] data2 = new String[ 512*3][512*3];
            int k=0;
            int j=height*3-1;
            while(j>0)
            {
                for(int i=0;i<width*3;i++)
                {
                    try {
                        data2[i][k]=data[j][i];
                       // System.out.println("VALEUR DE I :: " +i);
                        //System.out.println("data1:" + data[j][i]);
                        //System.out.println("data2:" + data2[i][k]);
                         wr.write(data2[i][k] + " ");
                        if(i==255)
                        {
                             //wr.write("\n");
                            break;          
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(LENA_HANDLER.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                j--;
                k++;
                
                
                
                
            }
          // wr.write(String.valueOf(data2[0][0]) + " hhhh");
       
}
}