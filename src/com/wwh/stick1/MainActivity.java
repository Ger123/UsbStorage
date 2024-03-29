package com.wwh.stick1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.userName);
    }
    	public void saveInternalCache(View view){
    		String data= editText.getText().toString();
    		File folder= getCacheDir();
    		File myFile= new File(folder, "mydata1.txt");
    		writeData(myFile,data);
    		
    		
    	}
    	public void saveExternalCache(View view){
    		String data= editText.getText().toString();
    		File folder= getExternalCacheDir();
    		File myFile= new File(folder, "mydata2.txt");
    		writeData(myFile,data);
    		
    		
    	}
    	public void savePrivateExternalFile(View view){
    		String data= editText.getText().toString();
    		File folder= getExternalFilesDir("slidenerd");
    		File myFile= new File(folder, "mydata3.txt");
    		writeData(myFile,data);
    		
    	}
    	public void savePublicExternalFile(View view){
    		String data= editText.getText().toString();
    		File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    		File myFile= new File(folder, "mydata4.txt");
    		writeData(myFile,data);
    		
    	}
    	private void writeData(File myFile, String data){
    		FileOutputStream fileOutputStream= null;
    		try {
				fileOutputStream= new FileOutputStream(myFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				fileOutputStream.write(data.getBytes());
				message(data+ " was sucessfully written " +myFile.getAbsolutePath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		finally{
    			if(fileOutputStream!= null){
    			try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		}
    		
    	}
    	public void next(View view){
    		Intent intent = new Intent(this, SecondActivity.class);
    		startActivity(intent);
    	}
    	public void message(String message){
    		Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    		
    	}
}
