/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.ikariworks.palindrome.prj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PalindromePrjActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button)findViewById(R.id.btnCheck);
        btn.setOnClickListener(this);
    }

	@Override
	public void onClick(View view) {
		int id = view.getId();
		switch(id){
		case R.id.btnCheck:
			EditText txt = (EditText)findViewById(R.id.txtPalidrome);
			TextView txtResult = (TextView)findViewById(R.id.txtResult);
			String str =txt.getText().toString();
			boolean result =isPalindrome(str);
			
			if(result){
				txtResult.setText("Yes it is");	
			}
			else {
				txtResult.setText("No it isn't");
			}
			break;
		}
		
	}
	
	private boolean isPalindrome(String str){
		str = str.trim();
		StringBuilder builder = new StringBuilder(str);
		String reversedStr = builder.reverse().toString();
		
		if(reversedStr.equalsIgnoreCase(str)){
			return true;
		}
		return false;
	}
	
	
}