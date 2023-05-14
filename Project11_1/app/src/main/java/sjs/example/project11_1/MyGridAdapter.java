import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;

import sjs.example.project11_1.MainActivity;
import sjs.example.project11_1.R;

class MyGridAdapter extends BaseAdapter {
    Context context;    //context : 안드로이드 애플리케이션의 전역 정보를 담고 있는 객체
    private Integer[] posterID = (MainActivity.class.context).posterID;

    public MyGridAdapter(Context _context) {
        context = _context;
    }
    //this.context = _context; 같은 뜻임
    //context : 안드로이드 애플리케이션의 전역 정보를 담고 있는 객체

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView ivG = new ImageView(context);
        ivG.setLayoutParams(new GridView.LayoutParams(250, 300));
        ivG.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ivG.setPadding(5, 5, 5, 5);

        ivG.setImageResource((MainActivity)context.posterID[i]);

        ivG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dig = new AlertDialog.Builder(MyGridAdapter.this);
                View digView = View.inflate(MainActivity.this , R.layout.dialog , null);
                ImageView img = digView.findViewById(R.id.ivPoster);
                img.setImageResource((MainActivity)context.posterID[i]);

                dig.setTitle("영화 포스터");
                dig.setIcon(R.mipmap.ic_launcher);
                dig.setView(digView);
                dig.setNegativeButton("닫기", null);
                dig.show();

            }
        });
        return ivG;
    }
}
