package datastructures;

public class Main {
    public static void main(String[] args) {
        App app =  new App();

        app.lruCache();
    }
}

class App {
    void lruCache() {
        LRUCache cache = new LRUCache();

        cache.set('a','a');
        cache.set('b','b');
        cache.set('c','c');
        cache.set('d','d');
        cache.set('e','e');
        cache.get('c');

        cache.printCacheChar();

    }
}

