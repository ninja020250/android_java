package mobile.nhatcuong.day09_pictures_menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryActivity extends AppCompatActivity {
    private Integer[] imageIds = {
            R.drawable.hinh1,
            R.drawable.hinh2,
            R.drawable.hinh3,
            R.drawable.hinh4,
    };

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter() {

        }

        public ImageAdapter(Context context) {
            this.context = context;
            TypedArray arr = obtainStyledAttributes(R.styleable.Gallery1);
            itemBackground = arr.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 0);
        }


        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(this.context);
                imageView.setImageResource(imageIds[position]);
                imageView.setLayoutParams(new Gallery.LayoutParams(100, 70));
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        final Gallery gallery = findViewById(R.id.gallery1);
        gallery.setAdapter(new ImageAdapter(this ));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GalleryActivity.this, "pic" + (position + 1 ), Toast.LENGTH_LONG).show();
                ImageView image =  findViewById(R.id.imageView1);
                image.setBackgroundResource(imageIds[position]);
            }
        });
    }
}
