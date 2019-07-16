package com.function.luo.gsondemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.function.luo.data.Animal;
import com.function.luo.data.Data;
import com.function.luo.data.Dog;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by luo on 2019/7/16.
 * <p>
 * 采用框架封装
 */

public class TwoActivity extends Activity {


    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;
    private User user;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);

        user = new User();
        user.setAddress("上海市，闵行区，大虹桥国际");
        user.setAge(22);
        user.setName("小明");

    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                //对象转化为 Json 数据
                String json =   GsonUtil.GsonString(user);
                Log.d("LUO","json=========="+json);
                //{"address":"上海市，闵行区，大虹桥国际","age":22,"name":"小明"}
                break;
            case R.id.btn_2:
                //对象转化为 Json 数据
                String json2 = GsonUtil.GsonString(user);

                Log.d("LUO","json2=========="+json2);
                //json 数据转化为 User 对象
                User user2 =   GsonUtil.GsonToBean(json2, User.class);

                Log.d("LUO","user2=========="+user2);
                // com.function.luo.gsondemo.User@e1e57f9
                break;
            case R.id.btn_3:
                User user31 = new User();
                user31.setAddress("上海市，闵行区，大虹桥国际");
                user31.setAge(22);
                user31.setName("小明");

                User user32 = new User();
                user32.setAddress("上海市，闵行区，凯德龙之梦");
                user32.setAge(21);
                user32.setName("小涛");

                User user33 = new User();
                user33.setAddress("上海市，闵行区，七宝古镇");
                user33.setAge(24);
                user33.setName("小红");

                UserGroup userGroup = new UserGroup();
                List<User> userList = new ArrayList<>();
                userList.add(user31);
                userList.add(user32);
                userList.add(user33);
                userGroup.setList(userList);
                userGroup.setOrganization("上海虹桥");

                String json3 =  GsonUtil.GsonString(userGroup);

                Log.d("LUO","json=========="+json3);
                //{"list":[{"address":"上海市，闵行区，大虹桥国际","age":22,"name":"小明"},{"address":"上海市，闵行区，凯德龙之梦","age":21,"name":"小涛"},{"address":"上海市，闵行区，七宝古镇","age":24,"name":"小红"}],"organization":"上海虹桥"}

                JsonObject jsonObject = (JsonObject) new JsonParser().parse(json3);

                String organization = String.valueOf(jsonObject.get("organization"));
                Log.d("LUO","organization=========="+organization);
                //数据转化为集合
                List<User> userList2 = GsonUtil.GsonToList(jsonObject.getAsJsonArray("list").toString(), User.class);
                Log.d("LUO","userList2=========="+userList2);
                break;
            case R.id.btn_4:
                parse4();
                break;
            case R.id.btn_5:
                parse5();
                break;
            default:
                break;
        }
    }





    /**
     * 二层嵌套
     */
    private void parse4() {


        List<User> UserList = new ArrayList<User>();
        UserList.add(new User("小红",27,"伯俊公司1"));
        UserList.add(new User("小亮",25,"伯俊公司2"));
        UserList.add(new User("小涛",24,"伯俊公司3"));


        UserGroup userGroup = new UserGroup("项目一",UserList);
        String jsonString =    GsonUtil.GsonString(userGroup);


        Log.d("LUO","======"+jsonString);
        //{"name":"项目一","users":[{"age":27,"company":"伯俊公司1","name":"小红","phone":"15618273672"},{"age":25,"company":"伯俊公司2","name":"小亮","phone":"15618273677"},{"age":24,"company":"伯俊公司3","name":"小涛","phone":"15618273676"}]}


        try {
            //转化为JSONObject对象

            JsonObject json = (JsonObject) new JsonParser().parse(jsonString);

            //获取name 值
            String organization = String.valueOf(json.get("organization"));


            Log.d("LUO","organization======"+organization);
            //name======项目一

            //转化为User集合
            List<User> list = GsonUtil.GsonToList(json.getAsJsonArray("list").toString(),User.class);
            Log.d("LUO","list======"+list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 三层嵌套
     */
    private void parse5() {


        Animal animal = new Animal();
        Data data = new Data();

        List<Dog> dogList = new ArrayList<>();
        Dog dog1 = new Dog();
        dog1.setAddress("上海市，闵行625 号");
        dog1.setAge(8);
        dog1.setName("小狗 1");

        Dog dog2 = new Dog();
        dog2.setAddress("上海市，闵行626 号");
        dog2.setAge(9);
        dog2.setName("小狗 2");

        Dog dog3 = new Dog();
        dog3.setAddress("上海市，闵行625 号");
        dog3.setAge(6);
        dog3.setName("小狗 3");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        data.setDog(dogList);
        data.setStore("闵行店");
        data.setId(10);

        animal.setData(data);
        animal.setResult("200");
        animal.setMessage("请求成功");



        String jsonStr =   GsonUtil.GsonString(animal);


        Log.d("LUO","======"+jsonStr);
        try {
            //{"data":{"dog":[{"address":"上海市，闵行625 号","age":8,"name":"小狗 1"},{"address":"上海市，闵行626 号","age":9,"name":"小狗 2"},{"address":"上海市，闵行625 号","age":6,"name":"小狗 3"}],"id":1,"store":"闵行店"},"message":"请求成功","result":"200"}

            JsonObject json = (JsonObject) new JsonParser().parse(jsonStr);

            //
            //获取 result 值
            String result = String.valueOf(json.get("result"));
            //获取 message 值
            String message = String.valueOf(json.get("message"));
            //获取 data 下面的 id 值

            JsonElement id = json.getAsJsonObject("data").get(("id"));
            //获取 data 下面的 store 值
            String store = String.valueOf(json.getAsJsonObject("data").get("store"));

            //获取 data 下面的 dog集合值（
            List<Dog> dogList5  = GsonUtil.GsonToList(json.getAsJsonObject("data").getAsJsonArray("dog").toString(),Dog.class);
            Log.d("LUO","result======"+result);
            // result======200
            Log.d("LUO","message======"+message);
            // message======请求成功
            Log.d("LUO","id======"+id);
            //id======10
            Log.d("LUO","store======"+store);
            //store======闵行店


            Log.d("LUO","dogList5======"+dogList5);
            // dogList5======[com.function.luo.data.Dog@3b81a4e, com.function.luo.data.Dog@3bb276f, com.function.luo.data.Dog@b8dcc7c]

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void launch(Context mContext) {
        Intent intent = new Intent(mContext,TwoActivity.class);
        mContext.startActivity(intent);
    }
}
