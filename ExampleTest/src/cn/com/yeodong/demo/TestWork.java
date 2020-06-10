package cn.com.yeodong.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestWork {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\YeDong\\Desktop\\BK_DMCS");
		if(file.isDirectory()) {
			File[] files = file.listFiles();
		//	System.out.println("=--------------" + files.length);
			for(File _file:files) {
				String[] fileName = _file.getName().split("\\.");
			//	System.out.println(fileName[0]);
				File  txtFile = new File("C:\\Users\\YeDong\\Desktop\\BK_DMCS字段映射\\"+fileName[0]+".txt");
			//	txtFile.createNewFile();
				readFile01(txtFile,fileName[0]);
			}
		}
	}
	/**
	 * 一行一行读取 文件
	 * @throws IOException
	 */
	public static void readFile01(File file,String fileName) throws IOException {
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        File resulst_file = new File("E:/result.txt");
        if(!resulst_file.exists()) {
        	resulst_file.createNewFile();
        }
        FileWriter fw=new FileWriter(resulst_file);
        BufferedWriter bw=new BufferedWriter(fw);
        String line="";
        String[] arrs=null;
        int count=0;
        while ((line=br.readLine())!=null) {
        	if(line.contains("	")) {
        		String[] array = line.split("	");
            	line = "COMMENT ON COLUMN \"BK_DMCS\".\""+fileName+ "\"."+ "\""+array[0]+"\"" +" IS "+"\'" +array[1]+"\';";	
            	System.out.println(line);
            //	bw.write(line+"\n");
        	}
        }
        
        bw.close();
        fw.close();
        
        br.close();
        fr.close();
        
   
    }
	/**
	 * 一行一行写入文件
	 * @throws IOException
	 */
	public void writeFile01() throws IOException {
        FileWriter fw=new FileWriter(new File("E:result.txt"));
        //写入中文字符时会出现乱码
        BufferedWriter  bw=new BufferedWriter(fw);
        //BufferedWriter  bw=new BufferedWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8")));
 
     
        bw.close();
        fw.close();
    }

}
