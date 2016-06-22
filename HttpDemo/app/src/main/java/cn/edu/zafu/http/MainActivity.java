package cn.edu.zafu.http;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get();
        //post();
        //getImage();
        //networkImageView();
        //json();
        //getAsync("http://121.41.119.107/test/index.php");
        /*
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://121.41.119.107")
                .build();
        PersonService personService=restAdapter.create(PersonService.class);
        personService.updatePerson("lizhangqu",23, new Callback<Person>() {
            @Override
            public void success(Person person, Response response) {
                Log.d("TAG", person.toString());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                /*
                String result = get("http://121.41.119.107/test/index.php");
                Log.d("TAG", result);
                Map<String, String> params=new HashMap<String, String>();
                params.put("user","asas");
                params.put("pass","12121");
                params.put("time","1212121");
                result = post("http://121.41.119.107/test/login.php",params);
                Log.d("TAG", result);
                */

                /*
                String result = get("http://121.41.119.107/test/index.php");
                Log.d("TAG", result);
                List<NameValuePair> params=new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("user","asas"));
                params.add(new BasicNameValuePair("pass","12121"));
                params.add(new BasicNameValuePair("time","1212121"));
                result = post("http://121.41.119.107/test/login.php",params);
                Log.d("TAG", result);

                */
                /*
                String result = get("http://121.41.119.107/test/index.php");
                Log.d("TAG", result);
                result = post("http://121.41.119.107/test/login.php");
                Log.d("TAG", result);
                Person p = gson("http://121.41.119.107/test/index.php");
                Log.d("TAG", p.toString());
                */
                /*
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint("http://121.41.119.107")
                        .build();
                PersonService personService=restAdapter.create(PersonService.class);
                Person person=personService.getPerson("test","zhangsan");
                Log.d("TAG",person.toString());

                Person person1=personService.updatePerson("lizhangqu", 12);
                Log.d("TAG",person1.toString());
                */
            }
        }).start();
    }

    /*
        private String get(String url) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private String post(String url) {
            OkHttpClient client = new OkHttpClient();

            RequestBody formBody = new FormEncodingBuilder()
                    .add("user", "Jurassic Park")
                    .add("pass", "asasa")
                    .add("time", "12132")
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        private Person gson(String url){
            OkHttpClient client = new OkHttpClient();
            Gson gson = new Gson();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                Person person = gson.fromJson(response.body().charStream(), Person.class);
                return person;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        */
    /*
    private void getAsync(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String result = response.body().string();
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                //不能操作ui，回调依然在子线程
                Log.d("TAG", result);
            }
        });


    }
    */
    /*
    private void get() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://121.41.119.107/test/index.php";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TAG", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }

    private void post() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://121.41.119.107/test/login.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TAG", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            //重写getParams方法设置参数
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user", "asas");
                params.put("pass", "12121");
                params.put("time", "1212121");
                return params;
            }
        };
        queue.add(request);
    }

    private void getImage() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://www.baidu.com/img/bdlogo.png";
        //第三第四个参数分别用于指定允许图片最大的宽度和高度，如果指定的网络图片的宽度或高度大于这里的最大值，则会对图片进行压缩，指定成0的话就表示不管图片有多大，都不会进行压缩。
        //第五个参数就是ImageView里中的属性ScaleType
        //第六个参数用于指定图片的颜色属性
        ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                ImageView iv= (ImageView) findViewById(R.id.iv);
                iv.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
    //继承ImageCache，使用LruCache实现缓存
    public class BitmapCache implements ImageLoader.ImageCache {
        private LruCache<String, Bitmap> mCache;
        public BitmapCache() {
            int maxSize = 10 * 1024 * 1024;
            mCache = new LruCache<String, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }
        @Override
        public Bitmap getBitmap(String url) {
            return mCache.get(url);
        }
        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            mCache.put(url, bitmap);
        }

    }
    private void getImageByImageLoader() {
        ImageView iv= (ImageView) findViewById(R.id.iv);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://www.baidu.com/img/bdlogo.png";
        ImageLoader loader=new ImageLoader(queue,new BitmapCache() );
        // 第一个参数指定用于显示图片的ImageView控件
        // 第二个参数指定加载图片的过程中显示的图片
        // 第三个参数指定加载图片失败的情况下显示的图片
        ImageLoader.ImageListener listener=ImageLoader.getImageListener(iv,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        // 调用ImageLoader的get()方法来加载图片
        // 第一个参数就是图片的URL地址
        // 第二个参数则是刚刚获取到的ImageListener对象
        // 如果想对图片的大小进行限制，也可以使用get()方法的重载，指定图片允许的最大宽度和高度，即通过第三第四个参数指定
        loader.get(url,listener);
    }
    public void networkImageView(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        ImageLoader loader=new ImageLoader(queue,new BitmapCache() );
        NetworkImageView niv= (NetworkImageView) findViewById(R.id.network_image_view);
        niv.setDefaultImageResId(R.mipmap.ic_launcher);
        niv.setErrorImageResId(R.mipmap.ic_launcher);
        niv.setImageUrl("https://www.baidu.com/img/bdlogo.png",
                loader);
    }
    private void json(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://121.41.119.107/test/index.php";
        GsonRequest<Person> request=new GsonRequest<Person>(url, Person.class, new Response.Listener<Person>() {
            @Override
            public void onResponse(Person response) {
                Log.d("TAG",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
    */
    /*
    private void get(){
        TestClient.get("test/index.php", null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    private void post(){
        RequestParams params = new RequestParams();
        params.put("user","asas");
        params.put("pass","12121");
        params.put("time","1212121");
        TestClient.post("test/login.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    */
    /*
    private String get(String url){
        HttpClient client=null;
        HttpGet request=null;
        try {
            client=new DefaultHttpClient();
            request=new HttpGet(url);
            HttpResponse response=client.execute(request);
            if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                String result=EntityUtils.toString(response.getEntity(),"UTF-8");
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
    private String post(String url,List<NameValuePair> params){
        HttpClient client=null;
        HttpPost request=null;
        try {
            client=new DefaultHttpClient();
            request=new HttpPost(url);
            request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse response=client.execute(request);
            if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                String result=EntityUtils.toString(response.getEntity(),"UTF-8");
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
    */
/*
    public String get(String urlPath) {
        HttpURLConnection connection = null;
        InputStream is = null;
        try {
            URL url = new URL(urlPath);
            //获得URL对象
            connection = (HttpURLConnection) url.openConnection();
            //获得HttpURLConnection对象
            connection.setRequestMethod("GET");
            // 默认为GET
            connection.setUseCaches(false);
            //不使用缓存
            connection.setConnectTimeout(10000);
            //设置超时时间
            connection.setReadTimeout(10000);
            //设置读取超时时间
            connection.setDoInput(true);
            //设置是否从httpUrlConnection读入，默认情况下是true;
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //相应码是否为200
                is = connection.getInputStream();
                //获得输入流
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                //包装字节流为字符流
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
                connection = null;
            }
            if (is != null) {
                try {
                    is.close();
                    is = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private String post(String urlPath, Map<String, String> params) {
        if (params == null || params.size() == 0) {
            return get(urlPath);
        }
        OutputStream os = null;
        InputStream is = null;
        HttpURLConnection connection = null;
        StringBuffer body = getParamString(params);
        byte[] data = body.toString().getBytes();
        try {
            URL url = new URL(urlPath);
            //获得URL对象
            connection = (HttpURLConnection) url.openConnection();
            //获得HttpURLConnection对象
            connection.setRequestMethod("POST");
            // 设置请求方法为post
            connection.setUseCaches(false);
            //不使用缓存
            connection.setConnectTimeout(10000);
            //设置超时时间
            connection.setReadTimeout(10000);
            //设置读取超时时间
            connection.setDoInput(true);
            //设置是否从httpUrlConnection读入，默认情况下是true;
            connection.setDoOutput(true);
            //设置为true后才能写入参数
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(data.length));
            os = connection.getOutputStream();
            os.write(data);
            //写入参数
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //相应码是否为200
                is = connection.getInputStream();
                //获得输入流
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                //包装字节流为字符流
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
                connection = null;
            }
        }
        return null;
    }

    private StringBuffer getParamString(Map<String, String> params) {
        StringBuffer result = new StringBuffer();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> param = iterator.next();
            String key = param.getKey();
            String value = param.getValue();
            result.append(key).append('=').append(value);
            if (iterator.hasNext()) {
                result.append('&');
            }
        }
        return result;
    }
    */
}
