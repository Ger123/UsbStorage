package com.wwh.stick1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {
	private EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		editText= (EditText) findViewById(R.id.userNameData);
	}

	public void loadInternalCache(View view) {
		File folder= getCacheDir();
		File myFile= new File(folder, "mydata1.txt");
		String data= readData(myFile);
		
		if(data!= null){
			editText.setText(data);
		}
		else{
			editText.setText("data not found");
		}
	}

	public void loadExternalCache(View view) {
		File folder= getExternalCacheDir();
		File myFile= new File(folder, "mydata2.txt");
		String data= readData(myFile);
		
		if(data!= null){
			editText.setText(data);
		}
		else{
			editText.setText("data not found");
		}

	}

	public void loadPrivateExternalFile(View view) {
		File folder= getExternalFilesDir("slidenerd");
		File myFile= new File(folder, "mydata3.txt");
		String data= readData(myFile);
		
		if(data!= null){
			editText.setText(data);
		}
		else{
			editText.setText("data not found");
		}

	}

	public void loadPublicExternalFile(View view) {
		File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		File myFile= new File(folder, "mydata4.txt");
		String data= readData(myFile);
		
		if(data!= null){
			editText.setText(data);
		}
		else{
			editText.setText("data not found");
		}

	}

	private String readData(File myFile) {
		StringBuffer stringBuffer = new StringBuffer();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(myFile);
			int read = -1;
			while ((read = fileInputStream.read()) != -1)
				;
			{
				stringBuffer.append((char) read);
			}
			return stringBuffer.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return null;

	}

	public void previous(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void message(String message) {
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}
}
