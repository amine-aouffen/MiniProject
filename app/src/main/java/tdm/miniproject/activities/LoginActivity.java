package tdm.miniproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import tdm.miniproject.R;
import tdm.miniproject.job.User;
import tdm.miniproject.managers.HttpManager;
import tdm.miniproject.managers.RequestManager;
import tdm.miniproject.managers.TasksManager;
import tdm.miniproject.managers.UserManager;
import tdm.miniproject.support.GeneralResponse;

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
        User user = new User();
        user.setUsername(userEditText.getText().toString());
        user.setPassword(userEditText.getText().toString());
        new AuthenTask(user).execute(user);

    }
    public void cancelAuthentification(){
        finish();

    }



    public void endActivity(){
        finish();
    }

    public class AuthenTask extends AsyncTask <User,Void,String>{
        private User user;

        public AuthenTask(User user) {
            this.user = user;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(User... params) {
            String result = new HttpManager()
                    .postDataToServiceURI(RequestManager.getRequestAuthen(),new Gson().toJson(params[0],User.class));

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            GeneralResponse response = new Gson().fromJson(s,GeneralResponse.class);
            if(response.getCode()==1){
                //Authen successfull
                UserManager.setConnected(getApplicationContext(),user.getUsername());
                setResult(Activity.RESULT_OK,new Intent());
                finish();
                TasksManager.setOrdderStatusChangedAlarm(getApplicationContext(),10);

            }else{
                Toast.makeText(getApplicationContext(),"Coordonées fournies sont incorrectes !", Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED,new Intent());
            }
        }
    }
}
