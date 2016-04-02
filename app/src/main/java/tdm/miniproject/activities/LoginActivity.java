package tdm.miniproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tdm.miniproject.R;
public class LoginActivity extends AppCompatActivity {
    private EditText userEditText;
    private EditText passEditText;
    private Button okBtn;
    private Button canclBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        configureLoginActivity();
        getViews();
        setButtonsListeners();
    }

    public void configureLoginActivity(){
        this.setFinishOnTouchOutside(false);
    }

    public void getViews(){
        userEditText = (EditText) findViewById(R.id.loginUserEdit);
        passEditText = (EditText) findViewById(R.id.loginPassEdit);
        okBtn = (Button) findViewById(R.id.loginOkBtn);
        canclBtn=(Button) findViewById(R.id.loginCancelBtn);
    }

    public void setButtonsListeners(){
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAuthentificationInfos();
            }
        });

        canclBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAuthentification();
            }
        });
    }

    public void sendAuthentificationInfos(){
        if(userEditText.getText().length()==0||passEditText.getText().length()==0){
            Toast.makeText(LoginActivity.this, "Veuillez saisir Nom utilisateur/Mot de passe", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent();
            intent.putExtra("user",userEditText.getText().toString());
            intent.putExtra("pass",passEditText.getText().toString());
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }
    public void cancelAuthentification(){
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED,intent);
        finish();
    }
}
