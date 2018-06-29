def searchElement(a, n):
    
    le = 0
    hg = len(a)-1
    
    if a == []:
        return False
        
    while le<=hg:
        mid = le + ((hg-le)/2)
        if n<a[mid]: hg = mid-1
        elif n>a[mid]: le = mid+1
        else: return True

    return False

# Tests

actual = searchElement([], 1)
expected = False
print(actual == expected)

actual = searchElement([1], 1)
expected = True
print(actual == expected)

actual = searchElement([1], 2)
expected = False
print(actual == expected)

actual = searchElement([2, 4, 6], 4)
expected = True
print(actual == expected)

actual = searchElement([2, 4, 6], 5)
expected = False
print(actual == expected)

actual = searchElement([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 8)
expected = True
print(actual == expected)

actual = searchElement([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 0)
expected = False
print(actual == expected)

