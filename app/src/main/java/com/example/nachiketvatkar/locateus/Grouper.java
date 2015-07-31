package com.example.nachiketvatkar.locateus;

public class Grouper {

    public int _gid;
    public int _mid;
    public String _mnam;

    public Grouper() {
    }

    public Grouper(int id,int id1,String name) {
        _gid=id;
        _mid=id1;
        _mnam=name;
    }

    public int get_gid() {
        return _gid;
    }

    public int get_mid() {
        return _mid;
    }

    public String get_mnam() {
        return _mnam;
    }
}
