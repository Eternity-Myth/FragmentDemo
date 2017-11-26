package gwc.com.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {
    // 底部菜单4个Linearlayout
    private LinearLayout ll_first;
    private LinearLayout ll_second;
    private LinearLayout ll_third;
    private LinearLayout ll_fourth;


    // 底部菜单4个菜单标题
    private TextView tv_first;
    private TextView tv_second;
    private TextView tv_third;
    private TextView tv_fourth;

    // 4个Fragment
    private Fragment firstFragment;
    private Fragment secondFragment;
    private Fragment thirdFragment;
    private Fragment fourthFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();
        // 初始化并设置当前Fragment
        initFragment(0);

    }

    private void initFragment(int index) {
        // 由于是引用了V4包下的Fragment，所以这里的管理器要用getSupportFragmentManager获取
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 隐藏所有Fragment
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (firstFragment == null) {
                    firstFragment = new FirstFragment();
                    transaction.add(R.id.fl_content, firstFragment);
                } else {
                    transaction.show(firstFragment);
                }
                break;
            case 1:
                if (secondFragment == null) {
                    secondFragment = new SecondFragment();
                    transaction.add(R.id.fl_content, secondFragment);
                } else {
                    transaction.show(secondFragment);
                }

                break;
            case 2:
                if (thirdFragment == null) {
                    thirdFragment = new ThirdFragment();
                    transaction.add(R.id.fl_content, thirdFragment);
                } else {
                    transaction.show(thirdFragment);
                }

                break;
            case 3:
                if (fourthFragment == null) {
                    fourthFragment = new FourthFragment();
                    transaction.add(R.id.fl_content, fourthFragment);
                } else {
                    transaction.show(fourthFragment);
                }

                break;

            default:
                break;
        }

        // 提交事务
        transaction.commit();

    }

    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (firstFragment != null) {
            transaction.hide(firstFragment);
        }
        if (secondFragment != null) {
            transaction.hide(secondFragment);
        }
        if (thirdFragment != null) {
            transaction.hide(thirdFragment);
        }
        if (fourthFragment != null) {
            transaction.hide(fourthFragment);
        }

    }

    private void initEvent() {
        // 设置按钮监听
        ll_first.setOnClickListener(this);
        ll_second.setOnClickListener(this);
        ll_third.setOnClickListener(this);
        ll_fourth.setOnClickListener(this);

    }

    private void initView() {

        // 底部菜单4个Linearlayout
        this.ll_first = (LinearLayout) findViewById(R.id.ll_first);
        this.ll_second = (LinearLayout) findViewById(R.id.ll_second);
        this.ll_third = (LinearLayout) findViewById(R.id.ll_third);
        this.ll_fourth = (LinearLayout) findViewById(R.id.ll_fourth);


        // 底部菜单4个菜单标题
        this.tv_first = (TextView) findViewById(R.id.tv_first);
        this.tv_second = (TextView) findViewById(R.id.tv_second);
        this.tv_third = (TextView) findViewById(R.id.tv_third);
        this.tv_fourth = (TextView) findViewById(R.id.tv_fourth);

    }

    @Override
    public void onClick(View v) {

        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_first:
//                iv_first.setImageResource(R.drawable.tab_weixin_pressed);
                tv_first.setTextColor(0xff00ff00);
                initFragment(0);
                break;
            case R.id.ll_second:
//                iv_second.setImageResource(R.drawable.tab_second_pressed);
                tv_second.setTextColor(0xff00ff00);
                initFragment(1);
                break;
            case R.id.ll_third:
//                iv_third.setImageResource(R.drawable.tab_find_frd_pressed);
                tv_third.setTextColor(0xff00ff00);
                initFragment(2);
                break;
            case R.id.ll_fourth:
//                iv_fourth.setImageResource(R.drawable.tab_find_frd_pressed);
                tv_fourth.setTextColor(0xff00ff00);
                initFragment(3);
                break;

            default:
                break;
        }

    }

    private void restartBotton() {
        // TextView置为灰色
        tv_first.setTextColor(0xff7F7F7F);
        tv_second.setTextColor(0xff7F7F7F);
        tv_third.setTextColor(0xff7F7F7F);
        tv_fourth.setTextColor(0xff7F7F7F);
    }

}