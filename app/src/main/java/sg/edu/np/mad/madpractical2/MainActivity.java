package sg.edu.np.mad.madpractical2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "On Create!");
        Button followButton = findViewById(R.id.followButton);
        Button messageButton = findViewById(R.id.messageButton);
        TextView nameText = findViewById(R.id.nameText);
        TextView descriptionText = findViewById(R.id.descriptionText);
        ImageView imageView = findViewById(R.id.imageView);
        User userObj = new User("Hello World!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                1, false);
        nameText.setText(userObj.name);
        descriptionText.setText(userObj.description);
        messageButton.setText("Message");
        if (userObj.followed) {
            followButton.setText("Unfollow");
        } else {
            followButton.setText("Follow");
        }

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Button Press");
                userObj.followed = !(userObj.followed);
                if (userObj.followed) {
                    followButton.setText("Unfollow");
                } else {
                    followButton.setText("Follow");
                }
            }
        });
    }
}