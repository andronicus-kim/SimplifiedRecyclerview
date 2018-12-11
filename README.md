# SimplifiedRecyclerview  
[ ![Download](https://api.bintray.com/packages/andronicus-kim/andronicus-repo/io.andronicus.simplifiedrecyclerview/images/download.svg?version=1.0.4) ](https://bintray.com/andronicus-kim/andronicus-repo/io.andronicus.simplifiedrecyclerview/1.0.4/link)

An android library to help you get rid of boiler plate code when setting up Recyclerview

## Download
You can grab SimplifiedRecyclerview via Maven:
```xml
<dependency>
  <groupId>io.andronicus.simplifiedrecyclerview</groupId>
  <artifactId>simplifiedrecyclerview</artifactId>
  <version>1.0.4</version>
  <type>pom</type>
</dependency>
```
or Gradle:

```gradle
dependencies {
  implementation 'io.andronicus.simplifiedrecyclerview:simplifiedrecyclerview:1.0.4'
}
```
## Usage
To be able to initialize MyAdapter, you will need 3 arguments, the layout id of Recyclerview viewholder list item, list of items you are interested in displaying and lastly implementation of ViewHolderCallbacks to handle binding data and view holder click events.
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); 
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");

        MyAdapter adapter = new MyAdapter<>(R.layout.list_item,strings,this);
        recyclerView.setAdapter(adapter);

    }
```
I passed *this for the 3rd argument above because MainActivity implements ViewHolderCallbacks as shown below.
The first method bindDataToViews allows you to bind data to views inside ViewHolder e.g Textviews... and the last method handles click events on the View holder.
```java
 public class MainActivity extends AppCompatActivity implements MyAdapter.ViewHolderCallbacks<String> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); 
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        
        MyAdapter adapter = new MyAdapter<>(R.layout.list_item,strings,this);
        recyclerView.setAdapter(adapter);
    }
    
    /*
    * Bind data to your views as you would normally do
    * in the view holder
    * */
    @Override
    public void bindDataToViews(String item, View view) {
        TextView textView = view.findViewById(R.id.tv_test);
        textView.setText(item);
    }

    /*
    * Handle click events from the view holder here
    * */
    @Override
    public void onViewHolderClick(String item,int position) {
        Toast.makeText(this, "Clicked at position" +  position, Toast.LENGTH_SHORT).show();
    }
    
    /*
    * Optionally you can turn your adapter to a field in
    * this case mAdapter and use it to get all or get one item
    * as illustrated below
    * */
    /*
    * Get all items from the Adapter
    * */
    private List<String> getAllItems(){
        return mAdapter.getAllItems();
    }

    /*
     * Get one item from the Adapter
     * */
    private String getOneItem(int position){
        return mAdapter.getItemAtPosition(position);
    }
    
    /*
     * Refresh or Update data
     * */
    private void setData(List<String> data){
        this.mAdapter.setData(data);
    }
}
```
With that, your recyclerview is good to go.
## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-feature-branch`
3. Commit your changes: `git commit -am 'new awesome feature'`
4. Push to the branch: `git push origin my-feature-branch`
5. Submit a pull request :D 
## Credits
Lead Android Engineer - Andronicus Kim(@andronicus_kim7)
## License
MIT License

Copyright (c) 2018 Andronicus

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
