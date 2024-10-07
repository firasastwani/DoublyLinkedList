
    Firas Astwani
    email: ffa53456@uga.edu


    Running and compiling:
    I did not use a run script. Just compile all the files then run the driver




    deleteSubsection psuedo code:

    input, lower bound and upper bound

    initiate curr node marker at head

    initate boolean inRange and set to false


    if the head is null return

    while curr is not null{

        if the current node is greater than the lower bound and lower than the upper bound remove it.

        if its the head or tail update it correctly

    update the back and next of curr

    move to the next node
    }

    This is O(N) because in the worst case it will traverse every node

  ---------


    reverseList pseudo code:

    if head is null or head.next is null return/

    initiate curr pointer at head
    initiate a temp node at null

    while curr is not null{

        set temp to curr.back
    set curr.back to curr.next
    set curr.next to temp

    set curr to curr.back.

    }

    This is O(N) because it has to iterate through every node


    --------

    swapAlt pseudo code:

    if head is null or head.next is null return

    Inititiate curr at head

    while curr and curr.next are not null{

    initialize first at curr and second at curr.next

    set first next to second next
    set second back to first back

    if first back is not null{
        first is set to second
    } else {
        head is set to second
    }

    set second next to first
    set first back to second

    set curr to next
    }

    This operation is O(N) because it traverses every node

    -----
