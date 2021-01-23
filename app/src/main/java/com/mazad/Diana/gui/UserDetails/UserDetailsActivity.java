package com.mazad.Diana.gui.UserDetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mazad.Diana.R;
import com.mazad.Diana.data.User;
import com.mazad.Diana.gui.EditProfile.EditProfileActivity;
import com.mazad.Diana.data.UserModel;
import com.mazad.Diana.utels.AppConstant;
import com.squareup.picasso.Picasso;

import static com.mazad.Diana.utels.AppKey.userData;

public class UserDetailsActivity extends AppCompatActivity {
    Button btnEditData;
    TextView tv_userName, tv_nickName, tv_phone, tv_email;
    de.hdodenhof.circleimageview.CircleImageView profile_Image,chatImge;

    User user ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        init();
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        user = (User) bundle.getParcelable(userData);
        declare(user);
    }

    public void init() {
        tv_nickName = findViewById(R.id.tvUserNameDetailsUserActivity);
        tv_phone = findViewById(R.id.tvPhoneDetailsUserActivity);
        tv_email = findViewById(R.id.tvEmailDetailsUserActivity);
        btnEditData = findViewById(R.id.btnEditDetailsUserActivity);
        profile_Image = findViewById(R.id.imageProfileDetailsUserActivity);
        chatImge = findViewById(R.id.chatImge);

    }

    public void declare(User userModel) {
        tv_email.setText(userModel.getEmail() + "");
        tv_phone.setText(userModel.getMobile() + "");
        tv_nickName.setText(userModel.getFirstName() + "");
        Picasso.get().load(AppConstant.BASE_IMAGE + userModel.getImage()).into(profile_Image);

        btnEditData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDetailsActivity.this, EditProfileActivity.class);
//                intent.putExtra("userModel", userModelRefrence);
                startActivity(intent);
            }
        });
        chatImge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
