package MatthewEricNick.HackThe90s;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.view.View;
import android.widget.ImageView;

public class MainUtility {

    public static ImageView addImage(Context con, String layoutName, String imageName, float x, float y) {
        int id = con.getResources().getIdentifier(layoutName, "id", con.getPackageName());
        ConstraintLayout map = ((Activity)con).findViewById(id);
        ConstraintSet set = new ConstraintSet();
        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        android.widget.ImageView image = new ImageView(con);
        image.setId(View.generateViewId());

        image.setImageResource(con.getResources().getIdentifier(imageName, "drawable", con.getPackageName()));
        image.setLayoutParams(lp);
        image.setX(x);
        image.setY(y);

        map.addView(image);
        set.clone(map);
        set.connect(image.getId(), ConstraintSet.TOP, map.getId(), ConstraintSet.TOP, 0);
        set.applyTo(map);

        return image;
    }

    public static void removeImage(Context con, ImageView imageView) {
        ConstraintLayout cl = ((Activity) con).findViewById(R.id.gameLayout);
        cl.removeView(imageView);
    }

    public static void centerImage(ImageView imageView) {
        imageView.setX(imageView.getX() - imageView.getLayoutParams().width/2);
        imageView.setY(imageView.getY() - imageView.getLayoutParams().height/2);
    }

    public static int getScreenWidth(Context con) {
        return con.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context con) {
        return con.getResources().getDisplayMetrics().heightPixels;
    }
}
