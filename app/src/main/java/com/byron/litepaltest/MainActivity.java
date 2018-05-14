package com.byron.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "Byron Wang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.create_database_button: {
                Connector.getDatabase();
                break;
            }

            case R.id.add_data_button: {
                Book book = new Book();
                book.setAuthor("Dan Brown");
                book.setName("The Da Vinci Code");
                book.setPages(454);
                book.setPrice(10.22);
                book.setPress("Unkonw");
                book.save();
                break;
            }

            case R.id.delete_data_button: {
                DataSupport.deleteAll(Book.class, "price < ?", "100");
                break;
            }

            case R.id.query_data_button: {
                List<Book> books = DataSupport.findAll(Book.class);
                for ( Book book : books ) {
                    Log.d(TAG, "onButtonClick: name:" + book.getName());
                    Log.d(TAG, "onButtonClick: author:" + book.getAuthor());
                    Log.d(TAG, "onButtonClick: price:" + book.getPrice());
                    Log.d(TAG, "onButtonClick: press:" + book.getPress());
                    Log.d(TAG, "onButtonClick: pages:" + book.getPages());
                }
                break;
            }
        }
    }
}
