package install.sinapse;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

public class OtroDispositivo_activity extends Activity{
	EditText nombre;
	ImageButton ButtonContinue;
	ImageButton ButtonAtras;
	
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.otro_dispositivo);
		
		ButtonContinue = (ImageButton) findViewById(R.id.continueButton);
		ButtonAtras = (ImageButton) findViewById(R.id.ButtonAtras);
			
		GlobalClass.id_otroDispositivo++;
		nombre = (EditText) findViewById(R.id.nombre);
		
		
		nombre.setText(GlobalClass.nom_otroDispositivo);
		
		
		nombre.setInputType(InputType.TYPE_CLASS_TEXT);
		
		this.ButtonContinue.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{			
				GlobalClass.nom_otroDispositivo = nombre.getText().toString();
				
				if(GlobalClass.nom_otroDispositivo.compareTo("")==0)
				{
					lanzaaviso();
				}
				else
				{
					Intent intent = new Intent();
					intent.setClass(OtroDispositivo_activity.this,Resumen_activity.class);
					startActivity(intent);
					finish();
				}
			}
		});
		
		this.ButtonAtras.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{
				alertaCerrar();
			}
		});
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch(keyCode)
		{
			case KeyEvent.KEYCODE_BACK:
			alertaCerrar();	
			return true;
		}
		return false;
	}
	
	public void alertaCerrar()
	{
		GlobalClass.id_otroDispositivo--;            
		Intent intent = new Intent();
    	intent.setClass(OtroDispositivo_activity.this,Gps_activity.class);
    	startActivity(intent);
        finish();
	}
	
	public void lanzaaviso() 
	{
		AlertDialog.Builder popup = new AlertDialog.Builder(this);
		popup.setTitle("Campo nombre vac�o");
		popup.setMessage("Por favor, introduzca un nombre");
		popup.setPositiveButton("Ok", null);
		popup.show();
	}
}
