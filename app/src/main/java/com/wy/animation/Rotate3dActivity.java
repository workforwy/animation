package com.wy.animation;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.wy.animation.R;
import com.wy.animation.rotate3d.MyAdapter;
import com.wy.animation.rotate3d.MyFragment;
import com.wy.animation.rotate3d.transformer.AlphaPageTransformer;
import com.wy.animation.rotate3d.transformer.DepthPageTransformer;
import com.wy.animation.rotate3d.transformer.MyTransformer;
import com.wy.animation.rotate3d.transformer.MyTransformerSecond;
import com.wy.animation.rotate3d.transformer.Test;
import com.wy.animation.rotate3d.transformer.ZoomOutPageTransformer;

public class Rotate3dActivity extends FragmentActivity {

	private ViewPager vp;
	private ZoomOutPageTransformer zoomOut;
	private AlphaPageTransformer alpha;
	private DepthPageTransformer depthPage;
	private MyTransformer transformer1;
	private MyTransformerSecond transformer2;
	private Test test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		List<Fragment> list = new ArrayList<Fragment>();
		list.add(new MyFragment());
		list.add(new MyFragment());
		list.add(new MyFragment());
		list.add(new MyFragment());
		MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), list);
		vp = (ViewPager) findViewById(R.id.vp);
		vp.setAdapter(adapter);

		test = new Test();
		zoomOut = new ZoomOutPageTransformer();
		alpha = new AlphaPageTransformer();
		depthPage = new DepthPageTransformer();
		transformer1 = new MyTransformer();
		transformer2 = new MyTransformerSecond();
		vp.setPageTransformer(true, transformer1);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_0:
			vp.setPageTransformer(true, test);
			break;
		case R.id.action_1:
			vp.setPageTransformer(true, zoomOut);
			break;
		case R.id.action_2:
			vp.setPageTransformer(true, alpha);
			break;
		case R.id.action_3:
			vp.setPageTransformer(true, depthPage);
			break;
		case R.id.action_4:
			vp.setPageTransformer(true, transformer1);
			break;
		case R.id.action_5:
			vp.setPageTransformer(true, transformer2);
			break;
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}