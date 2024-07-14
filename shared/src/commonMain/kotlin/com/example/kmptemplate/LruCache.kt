package com.example.kmptemplate

import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.locks.ReentrantLock
import kotlinx.atomicfu.locks.synchronized
import kotlinx.coroutines.internal.synchronized
import kotlin.jvm.Synchronized

class NetworkCache<K : Any, V : Any>(private val cacheSize: Int) {
    private val hashMap = LinkedHashMap<K, V>(cacheSize, 0.75f, )
    private val lock = Any()

//    fun removeEldestEntry(oldest: Map.Entry<K, V>): Boolean {
//        return size > cacheSize
//    }
//    fun get(key: K): V? {
//       synchronized(lock){
//
//       }
//        try {
//            lock.lock()
//            return hashMap[key]
//        } finally {
//            lock.unlock()
//        }
//    }
//
//    fun put(key: K, value: V): V? {
//        try {
//            lock.lock()
//            return hashMap.put(key, value)
//        } finally {
//            lock.unlock()
//        }
//    }
}
