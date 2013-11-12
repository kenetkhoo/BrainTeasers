package com.cs365.uclick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends Activity implements OnClickListener {
	private EditText email;
	private Button back, send1, send2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.password);

		email = (EditText) this.findViewById(R.id.pass_email);
		back = (Button) this.findViewById(R.id.passbtn_back);
		send1 = (Button) this.findViewById(R.id.passbtn_send);
		send2 = (Button) this.findViewById(R.id.passbtn_send2);

		back.setOnClickListener(this);
		send1.setOnClickListener(this);
		send2.setOnClickListener(this);

		email.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if (!MyRegex.isEmailValid(s.toString()))
					email.setError("Invalid Email");

			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == back) {
			Intent intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
		}

		else if (v == send1 || v == send2) {
			// dialog box
			if (MyRegex.isEmailValid(email.getText().toString())) {
				//send password to email
				Toast.makeText(this, "Password has been sent to your email!",
						Toast.LENGTH_SHORT).show();
			}

		}

	}
}
