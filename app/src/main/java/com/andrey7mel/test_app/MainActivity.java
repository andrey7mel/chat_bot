package com.andrey7mel.test_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andrey7mel.test_app.other.App;
import com.andrey7mel.test_app.presenter.Presenter;
import com.andrey7mel.test_app.view.Message;
import com.andrey7mel.test_app.view.View;
import com.andrey7mel.test_app.view.adapters.MessageAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View {

    private MessageAdapter adapter;

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.getComponent().inject(this);

        presenter.onCreate(this, savedInstanceState);
        adapter = new MessageAdapter();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void showMessage(Message message) {
        adapter.showMessage(message);
    }

    @Override
    public void showHistory(List<Message> list) {

    }
}
