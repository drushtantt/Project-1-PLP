program Test5Inheritance;

type
  TAnimal = class
  public:
    value: integer;
    constructor Create();
    procedure Speak();
    function GetValue(): integer;
  end;

  TDog = class(TAnimal)
  public:
    constructor Create();
    procedure Speak();
  end;

constructor TAnimal.Create();
begin
  value := 1;
  writeln(10);
end;

procedure TAnimal.Speak();
begin
  writeln(20);
end;

function TAnimal.GetValue(): integer;
begin
  GetValue := value;
end;

constructor TDog.Create();
begin
  value := 2;
  writeln(30);
end;

procedure TDog.Speak();
begin
  writeln(40);
end;

var
  a: TAnimal;
  d: TDog;
  x: integer;

begin
  a := TAnimal.Create();
  d := TDog.Create();
  a.Speak();
  d.Speak();
  x := a.GetValue();
  writeln(x);
  x := d.GetValue();
  writeln(x);
end.
