package me.rahulsengupta.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import me.rahulsengupta.persistence.dao.PhotoDao
import me.rahulsengupta.persistence.entity.PhotoEntity

object DatabaseMeta {
    const val NAME = "architecture_sample_db.db"
    const val VERSION = 1
}

@Database(entities = arrayOf(PhotoEntity::class), version = DatabaseMeta.VERSION)
abstract class ArchitectureSampleDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}