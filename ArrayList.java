public class ArrayList<T> implements List<T>{
	private T[] a;
	private int size;

	public ArrayList(){
		size=0;
		a=(T[]) new Object[10];
	}

	public void grow_array(){
		T[] new_arr = (T[]) new Object[a.length*2];
		for(int i=0; i<a.length; i++)
			new_arr[i]=a[i];
		a=new_arr;
	}

	//size is the next open index in the list
	public void add(T item){
		if(a.length==size)
			grow_array();
		a[size++]=item;
	}

	public void add(int pos, T item){
		if(pos<0||pos>size)
			System.out.println("Position is less than zero or greater than the size of the list");
		if(a.length==size)
			grow_array();
		if(size==0)
			a[size++]=item;
		else{
			for(int i=size; i>=pos; i--)
				a[i]=a[i-1];
			a[pos]=item;
			size++;
		}
	}

	public T get(int pos){
		if(pos<0||pos>size)
			System.out.println("The position does not exist in the list");
		return a[pos];
	}

	public T remove(int pos){
		if(pos<0||pos>size)
			System.out.println("The position does not exist in the list");
		T rem = a[pos];
		for(int i=pos; i<size-1; i++)
			a[i] = a[i+1];
		--size;
		return rem;
	}

	public int size(){
		return size;
	}
}