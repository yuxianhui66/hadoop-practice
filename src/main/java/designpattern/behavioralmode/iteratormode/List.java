package designpattern.behavioralmode.iteratormode;

public interface List<E> {
    void add(E obj);

    void remove(E obj);
    Iterator iterator();
}
