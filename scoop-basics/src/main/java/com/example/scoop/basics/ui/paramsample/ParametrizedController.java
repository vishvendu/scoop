package com.example.scoop.basics.ui.paramsample;

import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import com.example.scoop.basics.R;
import com.lyft.scoop.EnterTransition;
import com.lyft.scoop.ExitTransition;
import com.lyft.scoop.Screen;
import com.lyft.scoop.ViewController;
import com.lyft.scoop.transitions.FadeTransition;
import javax.inject.Inject;

//@InjectThat(ParametrizedController.Module.class)
@EnterTransition(FadeTransition.class)
@ExitTransition(FadeTransition.class)
public class ParametrizedController extends ViewController {

    public static Screen createScreen(String param) {
        return Screen.create(ParametrizedController.class)
                .setArgs(param);
    }

    @dagger.Module(
    )
    public static class Module {}

    @Bind(R.id.param_text_view)
    TextView paramTextView;

    @Inject
    public ParametrizedController() {
    }

    @Override
    protected int layoutId() {
        return R.layout.parametrized;
    }

    @Override
    public void attach(View view) {
        super.attach(view);

        String args = Screen.fromController(this).args();
        paramTextView.setText(args);
    }

    @Override
    public void detach(View view) {
        super.detach(view);
    }
}
