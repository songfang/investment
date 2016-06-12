package com.xh.investment.crawler;

import java.io.BufferedReader;  
import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.HttpURLConnection;  
import java.net.URL;  


public class HttpUtils  
{  

    private static final int TIMEOUT_IN_MILLIONS = 5000;  

    public interface CallBack  
    {  
        void onRequestComplete(String result);  
    }  


    /** 
     * 
     *  
     * @param urlStr 
     * @param callBack 
     */  
    public static void doGetAsyn(final String urlStr, final CallBack callBack)  
    {  
        new Thread()  
        {  
            public void run()  
            {  
                try  
                {  
                    String result = doGet(urlStr);  
                    if (callBack != null)  
                    {  
                        callBack.onRequestComplete(result);  
                    }  
                } catch (Exception e)  
                {  
                    e.printStackTrace();  
                }  

            };  
        }.start();  
    }  

    /** 
     * 
     * @param urlStr 
     * @param params 
     * @param callBack 
     * @throws Exception 
     */  
    public static void doPostAsyn(final String urlStr, final String params,  
            final CallBack callBack) throws Exception  
    {  
        new Thread()  
        {  
            public void run()  
            {  
                try  
                {  
                    String result = doPost(urlStr, params);  
                    if (callBack != null)  
                    {  
                        callBack.onRequestComplete(result);  
                    }  
                } catch (Exception e)  
                {  
                    e.printStackTrace();  
                }  

            };  
        }.start();  

    }  

    /** 
     *
     *  
     * @param urlStr 
     * @return 
     * @throws Exception 
     */  
    public static String doGet(String urlStr)   
    {  
        URL url = null;  
        HttpURLConnection conn = null;  
        InputStream is = null;  
        ByteArrayOutputStream baos = null;  
        try  
        {  
            url = new URL(urlStr);  
            conn = (HttpURLConnection) url.openConnection();  
            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);  
            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);  
            conn.setRequestMethod("GET");  
            conn.setRequestProperty("accept", "*/*");  
            conn.setRequestProperty("Accept-Charset", "GBK");
            conn.setRequestProperty("contentType", "GBK");
            conn.setRequestProperty("connection", "Keep-Alive");  
            
/*           if (conn.getResponseCode() == 200)  
            {  
                is = conn.getInputStream();
                baos = new ByteArrayOutputStream();  
                int len = -1;  
                byte[] buf = new byte[128];  

                while ((len = is.read(buf)) != -1)  
                {  
                    baos.write(buf, 0, len);  
                }  
                baos.flush();  
                return baos.toString();  
            } else  
            {  
                throw new RuntimeException(" responseCode is not 200 ... ");  
            }*/
            
            if(conn.getResponseCode() == 200){
            	InputStream inStream = conn.getInputStream();
            	BufferedReader in = new BufferedReader(new InputStreamReader(inStream,"GBK"));
            	StringBuffer buffer = new StringBuffer();
            	String line ="";
            	while((line=in.readLine())!=null){
            		buffer.append(line);
            	}
            	return buffer.toString();
            } else{
            	throw new RuntimeException(" responseCode is not 200 ... ");  
            }

        } catch (Exception e)  
        {  
            e.printStackTrace();  
        } finally  
        {  
            try  
            {  
                if (is != null)  
                    is.close();  
            } catch (IOException e)  
            {  
            }  
            try  
            {  
                if (baos != null)  
                    baos.close();  
            } catch (IOException e)  
            {  
            }  
            conn.disconnect();  
        }  
          
        return null ;  

    }  

    /**  
     * @param url          
     * @param param         
     * @return 
     * @throws Exception  
     */  
    public static String doPost(String url, String param)   
    {  
        PrintWriter out = null;  
        BufferedReader in = null;  
        String result = "";  
        try  
        {  
            URL realUrl = new URL(url);  
           
            HttpURLConnection conn = (HttpURLConnection) realUrl  
                    .openConnection();  
            conn.setRequestProperty("accept", "*/*");  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestMethod("POST");  
            conn.setRequestProperty("Content-Type",  
                    "application/x-www-form-urlencoded");  
            conn.setRequestProperty("charset", "utf-8");  
            conn.setUseCaches(false);  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);  
            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);  

            if (param != null && !param.trim().equals(""))  
            {  
                out = new PrintWriter(conn.getOutputStream());  
                out.print(param);  
                out.flush();  
            }  
            in = new BufferedReader(  
                    new InputStreamReader(conn.getInputStream()));  
            String line;  
            while ((line = in.readLine()) != null)  
            {  
                result += line;  
            }  
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
        finally  
        {  
            try  
            {  
                if (out != null)  
                {  
                    out.close();  
                }  
                if (in != null)  
                {  
                    in.close();  
                }  
            } catch (IOException ex)  
            {  
                ex.printStackTrace();  
            }  
        }  
        return result;  
    }  
    
    
    public static void main(String[] args) {
    	String message = HttpUtils.doGet("http://hq.sinajs.cn/list=RB1701");
    	String[] RB1701 = message.split("=");
    	System.out.println(RB1701[1]);
    	
	}
} 