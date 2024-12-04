# Gitlet Design Document

**Name**:

## Classes and Data Structures

**Note**: reference or id is sha1 result of object

### Class Commit

#### Fields

1. message: log message
2. id
3. parent commits
4. tree

### Class Tree

#### Fields

1. map name to reference (both file/blob and directory/tree )

### Class Blob

1. filename
2. content
3. id

## Algorithms

## Persistence

