create table words.sentence
(
    id    uuid,
    words text,
    primary key (id)
)
with caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}
     and compaction = {'max_threshold': '32', 'min_threshold': '4', 'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy'}
     and compression = {'class': 'org.apache.cassandra.io.compress.LZ4Compressor', 'chunk_length_in_kb': '64'}
     and dclocal_read_repair_chance = 0.1;



