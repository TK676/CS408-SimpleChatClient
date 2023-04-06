package edu.jsu.mcis.cs408.simplechatclient;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.beans.PropertyChangeEvent;
import edu.jsu.mcis.cs408.simplechatclient.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AbstractView {

    public static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private DefaultController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        controller = new DefaultController();
        ChatClientModel model = new ChatClientModel();

        controller.addView(this);
        controller.addModel(model);

        model.initDefault();

        binding.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.sendDeleteRequest();
            }
        });

        binding.postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.sendPostRequest(binding.inputField.getText().toString());
            }
        });
    }

    @Override
    public void modelPropertyChange(final PropertyChangeEvent evt) {

        String propertyName = evt.getPropertyName();
        String propertyValue = evt.getNewValue().toString();

        Log.i(TAG, "New " + propertyName + " Value from Model: " + propertyValue);

        if ( propertyName.equals(DefaultController.ELEMENT_OUTPUT_PROPERTY) ) {
            String oldPropertyValue = binding.outputArea.getText().toString();

            if ( !oldPropertyValue.equals(propertyValue) ) {
                binding.outputArea.setText(propertyValue);
            }
        }
    }
}