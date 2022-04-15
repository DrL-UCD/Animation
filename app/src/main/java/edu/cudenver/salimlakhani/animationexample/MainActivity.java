package edu.cudenver.salimlakhani.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView messageTextView;
    private Button actionButton;
    private ImageView imageView;

    //Reference variable for my animation.
    private Animation animation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get references to Views
        messageTextView = findViewById(R.id.messageTextView);
        actionButton = findViewById(R.id.actionButton);
        imageView = findViewById(R.id.imageView);

        //Get reference to Animation
        animation = AnimationUtils.loadAnimation(this, R.anim.animation);


        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //animation.setStartTime(500);
                Log.i ("info", "Starting animation");
                animation.setDuration(5000);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        messageTextView.setText("RUNNING");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        messageTextView.setText("STOPPED");

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                imageView.startAnimation(animation);
            }
        });
    }


}