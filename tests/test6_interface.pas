program Test6Interface;

type
  IPrintable = interface
    procedure Print();
  end;

  TNumber = class implements IPrintable
  public:
    value: integer;
    constructor Create(v: integer);
    procedure Print();
  end;

constructor TNumber.Create(v: integer);
begin
  value := v;
end;

procedure TNumber.Print();
begin
  writeln(value);
end;

var
  n: TNumber;
  p: IPrintable;
  x: integer;

begin
  readln(x);
  n := TNumber.Create(x);
  p := n;
  p.Print();
  writeln(x);
end.
