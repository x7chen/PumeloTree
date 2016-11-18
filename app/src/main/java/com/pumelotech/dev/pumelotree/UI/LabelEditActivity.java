package com.pumelotech.dev.pumelotree.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pumelotech.dev.pumelotree.MyApplication;
import com.pumelotech.dev.pumelotree.R;

public class LabelEditActivity extends AppCompatActivity {

    EditText etGoodsName;
    EditText etPrice;
    EditText etUnit;
    EditText etPackage;
    EditText etNumber;
    EditText etOrigin;

    GoodsInfo goods = new GoodsInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label_edit);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_lable_edit);
        mToolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        mToolbar.setTitle("编辑");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        etGoodsName = (EditText) findViewById(R.id.et_name);
        etNumber = (EditText) findViewById(R.id.et_id);
        etPrice = (EditText) findViewById(R.id.et_price);
        etUnit = (EditText) findViewById(R.id.et_unit);
        etPackage = (EditText) findViewById(R.id.et_package);
        etOrigin = (EditText) findViewById(R.id.et_origin);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.done, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_done:
                goods.Name = etGoodsName.getText().toString();
                goods.Identifier = etNumber.getText().toString();
                goods.Price = etPrice.getText().toString();
                goods.Unit = etUnit.getText().toString();
                goods.Package = etPackage.getText().toString();
                goods.Origin = etOrigin.getText().toString();

                    if (MyApplication.LabelListActivity != null) {
                        MyApplication.LabelListActivity.addLabel(goods);
                    }

                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
