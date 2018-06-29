def traverse(a,x): 
    if x==None: return None
    traverse(a,x.rt)
    a.append(x.value)
    if len(a) >= 2: return None
    traverse(a,x.lt)

def sec_largest(r):

    if r == None:
        raise ValueError()
    a = []
    # inorder
    traverse(a,r)

    return a[1]

# Tests

class Node(object):

    def __init__(self, value):
        self.value = value
        self.lt = None
        self.rt = None

    def ins_lt(self, value):
        self.lt = Node(value)
        return self.lt

    def ins_rt(self, value):
        self.rt = Node(value)
        return self.rt

graph1 = Node(50)
lt = graph1.ins_lt(30)
rt = graph1.ins_rt(70)
lt.ins_lt(10)
lt.ins_rt(40)
rt.ins_lt(60)
rt.ins_rt(80)
actual = sec_largest(graph1)
expected = 70
print(actual == expected)

graph2 = Node(50)
lt = graph2.ins_lt(30)
rt = graph2.ins_rt(70)
lt.ins_lt(10)
lt.ins_rt(40)
rt.ins_lt(60)
actual = sec_largest(graph2)
expected = 60
print(actual == expected)

graph3 = Node(50)
lt = graph3.ins_lt(30)
rt = graph3.ins_rt(70)
lt.ins_lt(10)
lt.ins_rt(40)
rt_lt = rt.ins_lt(60)
rt_lt_lt = rt_lt.ins_lt(55)
rt_lt.ins_rt(65)
rt_lt_lt.ins_rt(58)
actual = sec_largest(graph3)
expected = 65
print(actual == expected)

graph4 = Node(50)
lt = graph4.ins_lt(30)
graph4.ins_rt(70)
lt.ins_lt(10)
lt.ins_rt(40)
actual = sec_largest(graph4)
expected = 50
print(actual == expected)

graph5 = Node(50)
lt = graph5.ins_lt(40)
lt_lt = lt.ins_lt(30)
lt_lt_lt = lt_lt.ins_lt(20)
lt_lt_lt.ins_lt(10)
actual = sec_largest(graph5)
expected = 40
print(actual == expected)

graph6 = Node(50)
rt = graph6.ins_rt(60)
rt_rt = rt.ins_rt(70)
rt_rt.ins_rt(80)
actual = sec_largest(graph6)
expected = 70
print(actual == expected)
