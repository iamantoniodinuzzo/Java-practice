public class Range<T extends Comparable<T>> {
    
    private T mMin, mMax;

    public Range(T min, T max){
        this.mMax = max;
        this.mMin = min;
    }

    public boolean isInside(T x){
        return ((x.compareTo(mMin) >= 0) && (x.compareTo(mMax) <= 0 ));
    }

    /**
     * 
     * @param <S> Una classe che deve essere figlia o uguale a T
     * @param x Un Range da confrontare
     * @return
     */
    public boolean isOverlapping(Range<? extends T> x){
        if(x.equals(this))
            return true;
        else if(mMax.compareTo(x.getmMin()) >= 0 && (mMax.compareTo(x.getmMax()) <= 0))//massimo > minimo altro insieme AND massimo < massimo altro insieme
            return true;
        else if(mMin.compareTo(x.getmMin()) >= 0 && (mMin.compareTo(x.getmMax()) <= 0))
            return true;

        return false;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Range)) throw new IllegalArgumentException();
        
        Range<T> r = (Range<T>) obj;

        return (r.getmMin().equals(mMin) && r.getmMax().equals(mMax));
    }

    @Override
    public int hashCode(){
        return mMax.hashCode() + mMin.hashCode();
    }

    public T getmMax() {
        return mMax;
    }

    public T getmMin() {
        return mMin;
    }

}
