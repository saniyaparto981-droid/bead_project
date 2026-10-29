interface IBeadTracker {

    void track(double tau, int min);

    String printMovements(IBeadFinder firstFinder,
                          IBeadFinder secondFinder);

}
