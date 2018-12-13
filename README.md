# GridViewPager
---
效果图
---
![image](https://github.com/mingyouzhu/GridViewPager-android/blob/master/20160913185125647.gif?raw=true)

---
使用：
---
```
package per.lijuan.meituan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.kerchin.widget.GridViewPager;
import com.kerchin.widget.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] titles = {"美食", "电影", "酒店住宿", "休闲娱乐", "外卖", "自助餐", "KTV", "机票/火车票", "周边游", "美甲美睫",
            "火锅", "生日蛋糕", "甜品饮品", "水上乐园", "汽车服务", "美发", "丽人", "景点", "足疗按摩", "运动健身", "健身", "超市", "买菜",
            "今日新单", "小吃快餐", "面膜", "洗浴/汗蒸", "母婴亲子", "生活服务", "婚纱摄影", "学习培训", "家装", "结婚", "全部分配"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridViewPager<Integer> mGridViewPager = findViewById(R.id.mGridViewPager);
        mGridViewPager.setPageSize(10);

        mGridViewPager.setImageLoader((context,icon,imageView) -> {
            //Glide.with(this).load(icon).apply(RequestOptions.overrideOf(120,120)).into(imageView);
            imageView.setImageResource(icon);
        });
        mGridViewPager.setGridItemLongClickListener((pos,model) -> {
            Toast.makeText(this, "You are was clicked: " + model.getName(), Toast.LENGTH_SHORT).show();
        });
        mGridViewPager.setGridItemClickListener((pos,model) -> {
            Toast.makeText(this, "You are was long clicked: " + model.getName(), Toast.LENGTH_SHORT).show();
        });
        mGridViewPager.init(initData());
    }

    private List<Model<Integer>> initData() {
        List<Model<Integer>> mData = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            // 动态获取资源ID
            int imageId = getResources().getIdentifier("ic_category_" + i, "mipmap", getPackageName());
            mData.add(new Model(titles[i],titles[i] + "描述",imageId));
        }
        return mData;
    }
}
```
