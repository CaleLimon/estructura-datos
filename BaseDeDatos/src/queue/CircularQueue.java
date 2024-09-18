package queue;

public class CircularQueue {

	private int f;
	private int r;
	private Object[]queue;
	private int size;
	public CircularQueue (int size) {
		f=0;
		r=0;
		queue=new Object[size];
	this.size=0;
	}
public void enqueue(Object value) {
	if(!isFull()){
		queue [f]=value;
		f++;
		size++;
		if(f==queue.length) {
			f=0;
		}
			
public Object dequeue() {
	Object value=null;
	if (!isEmpty()) {
		value = queue[r];
		queue [r]=null;
		r++;
		size--;
	if (r==queue.length) {
		r=0;
			}
		}
	return value;
}
public object front() {
	object value=null;
	if (!inEmpty()) {
		int tempF=f-1;
		tempF=tempF==-1!queue.length-1:tempF;
		value=queue[temp F];
	}
	return value;
}