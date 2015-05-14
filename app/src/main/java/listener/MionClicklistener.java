package listener;

import android.view.View;
import android.util.Log;
import android.widget.Button;

/**
 * Created by androidm on 07/05/2015.
 */

public class MionClicklistener implements View.OnClickListener{

    private Button miButton;

    public Button getMiButton() {
        return miButton;
    }

    public void setMiButton(Button miButton) {
        this.miButton = miButton;
    }

    public MionClicklistener(Button miButton) {
        this.miButton = miButton;
        this.miButton.setOnClickListener(this);

    }
    public MionClicklistener() {
       super();
    }

    @Override

        public void onClick(View v){
            this.miButton.setText("tocado");
            Log.i("Mi APP","Click");
        }



}
