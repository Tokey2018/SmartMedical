package com.tokeys.im.servcice;

import com.tokeys.im.model.Friend;

import java.util.ArrayList;
import java.util.List;

public class FriendServiceTest {


    public void batchStrongAdd() {
    }
    public static void main(String[] args) {
        List<Friend> friends=new ArrayList<>( );
        Friend f1=new Friend();
        f1.setAccid( "20161115289336n3" );
        f1.setFaccid( "2016062963250g5o" );
        f1.setType( 1 );
        Friend f2=new Friend();
        f2.setAccid( "20161115289336n3" );
        f1.setFaccid( "201605046325f3j4" );
        f2.setType( 1 );

        Friend f3=new Friend();
        f3.setAccid( "20161115289336n3" );
        f3.setFaccid( "201606299472nqck_11" );
        f3.setType( 1 );

        friends.add( f1 );
        friends.add( f2 );
        friends.add( f3 );
        System.out.println("多 线程执行结果:=="+new FriendService(). batchStrongAdd(friends));
        // System.out.println("单线程执行结果:=="+new FriendService(). add(f1));


    }


}